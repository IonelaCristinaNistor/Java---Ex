package com.example.demo;

import jakarta.persistence.*;
@Entity
@Table(name = "Malta")
public class Malta {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "commentId")
        private long commentId;

        @Column(name = "topicId")
        private String topicId;
}
