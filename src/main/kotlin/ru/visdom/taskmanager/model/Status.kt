package ru.visdom.taskmanager.model

import javax.persistence.*

@Entity
@Table(name = "status")
data class Status(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,

        @Column(name = "name")
        val name: String,

        @Column(name = "description")
        val description: String
)