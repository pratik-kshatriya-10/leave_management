package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.DesignationDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Designation;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface DesignationService {
    int addDesignation(@Valid DesignationDto dto);

    int updateDesignation(@Valid DesignationDto dto,
                          @NotEmpty(message = Messages.REQUIRED_DESIGNATION_ID) String designationId);

    int deleteDesignation(@NotEmpty(message = Messages.REQUIRED_DESIGNATION_ID) String designationId);

    Designation fetchDesignation(@NotEmpty(message = Messages.REQUIRED_DESIGNATION_ID) String designationId);

    int fetchDesignationCount(@Valid PaginationDto paginationDto);

    List<Designation> fetchDesignationList(@Valid PaginationDto paginationDto);
}
