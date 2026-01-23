package com.example.stms;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotBlank(message = "Description must not be empty")
    private String description;

    @NotNull(message = "Status must be PENDING, IN_PROGRESS or DONE")
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public String getStatusDescription() {
        if (status == null) {
            return null;
        }
        return status.getDescription();
    }
}
