package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.Department;
import com.umb.laura.aviles.ecommerce.repository.DeparmentRepostory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeparmentService {

    private DeparmentRepostory deparmentRepostory;

    public List<Department> getDepartments() {
        return deparmentRepostory.getDepartments();
    }
}
