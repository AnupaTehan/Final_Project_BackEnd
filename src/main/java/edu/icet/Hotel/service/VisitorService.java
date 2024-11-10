package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {


    void   addNewVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

     Optional<Visitor> searchVisitor(String fullName);
}
