package edu.icet.hotel.service.impl;

import edu.icet.hotel.dto.OnlineVisitor;
import edu.icet.hotel.dto.Visitor;
import edu.icet.hotel.entity.OnlineVisitorEntity;
import edu.icet.hotel.entity.VisitorEntity;
import edu.icet.hotel.repository.OnlineVisitorRepository;
import edu.icet.hotel.service.OnlineVisitorLoginService;
import edu.icet.hotel.service.OnlineVisitorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor

public class OnlineVisitorServiceImpl implements OnlineVisitorService {

    private final OnlineVisitorRepository onlineVisitorRepository;

    final ModelMapper modelMapper;



    @Override
    public void registerNewOnlineVisitor(OnlineVisitor onlineVisitor) {
        OnlineVisitorEntity onlineVisitorEntity = modelMapper.map(onlineVisitor, OnlineVisitorEntity.class);
        onlineVisitorRepository.save(onlineVisitorEntity);
    }

    @Override
    public List<OnlineVisitor> getOnlineVisitors() {
        List<OnlineVisitor> onlineVisitors = new ArrayList<>();
        onlineVisitorRepository.findAll().forEach(OnlineVisitorEntity->{
            onlineVisitors.add(modelMapper.map(OnlineVisitorEntity, OnlineVisitor.class));
        });
        return onlineVisitors;
    }

    @Override
    public Optional<OnlineVisitor> searchOnlineVisitor(String fullNameOnl) {
        OnlineVisitorEntity onlineVisitorEntity = onlineVisitorRepository.findByfullNameOnl(fullNameOnl);

        if (onlineVisitorEntity == null) {
            return Optional.empty();
        }

        OnlineVisitor onlineVisitor = modelMapper.map(onlineVisitorEntity, OnlineVisitor.class);
        return Optional.of(onlineVisitor);
    }
}
