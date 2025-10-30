package com.example.mobilefix.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "repair_orders")
public class RepairOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(nullable = false)
    private String issueDescription;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_tech_id")
    private User assignedTech;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    private String tech_notes;

    public RepairOrder(){}

    public RepairOrder(Long id, User user, Device device, String issueDescription, String status, User assignedTech, LocalDateTime create_at, LocalDateTime updated_at, String tech_notes) {
        this.id = id;
        this.user = user;
        this.device = device;
        this.issueDescription = issueDescription;
        this.status = status;
        this.assignedTech = assignedTech;
        this.created_at = create_at;
        this.updated_at = updated_at;
        this.tech_notes = tech_notes;
    }

    @PrePersist
    protected void onCreate(){
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_at = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }
    public void setDevice(Device device) {
        this.device = device;
    }

    public String getIssueDescription() {
        return issueDescription;
    }
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedTech() {
        return assignedTech;
    }
    public void setAssignedTech(User assignedTech) {
        this.assignedTech = assignedTech;
    }

    public LocalDateTime getCreate_at() {
        return created_at;
    }
    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public String getTech_notes() {
        return tech_notes;
    }
    public void setTech_notes(String tech_notes) {
        this.tech_notes = tech_notes;
    }
}
