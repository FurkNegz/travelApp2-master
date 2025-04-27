package com.muratesenkaya.travelApp.service;

import com.muratesenkaya.travelApp.dto.TagDTO;
import com.muratesenkaya.travelApp.mapper.TagMapper;
import com.muratesenkaya.travelApp.model.Tag;
import com.muratesenkaya.travelApp.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public TagDTO createTag(TagDTO tagDTO) {
        Tag tag = TagMapper.toEntity(tagDTO);
        Tag savedTag = tagRepository.save(tag);
        return TagMapper.toDTO(savedTag);
    }

    public List<TagDTO> getAllTags() {
        return tagRepository.findAll().stream()
                .map(TagMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TagDTO getTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
        return TagMapper.toDTO(tag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
