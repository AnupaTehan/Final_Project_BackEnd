package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.entity.VisitorEntity;
import edu.icet.Hotel.repository.VisitorRepository;
import edu.icet.Hotel.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class VisitorServiceImpl  implements VisitorService {
    
    private final VisitorRepository visitorRepository;

    final ModelMapper modelMapper;
    
    
    
    @Override
    public void  addNewVisitor(Visitor visitor) {
        VisitorEntity visitorEntity = visitorRepository.save(modelMapper.map(visitor, VisitorEntity.class));

    }

    @Override
    public List<Visitor> getAllVisitors() {
       List<Visitor> visitors = new ArrayList<>();

       visitorRepository.findAll().forEach(VisitorEntity->{
           visitors.add(modelMapper.map(VisitorEntity,Visitor.class));
       });
       return  visitors;
    }

    @Override
    public Optional<Visitor> searchVisitor(String fullName) {
        VisitorEntity visitorEntity = visitorRepository.findByfullName(fullName);

        if (visitorEntity == null) {
            return Optional.empty();
        }

        Visitor visitor = modelMapper.map(visitorEntity, Visitor.class);
        return Optional.of(visitor);
    }
}
