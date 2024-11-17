package edu.icet.hotel.service;

import edu.icet.hotel.dto.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {


    void   addNewVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

     Optional<Visitor> searchVisitor(String fullName);
}
