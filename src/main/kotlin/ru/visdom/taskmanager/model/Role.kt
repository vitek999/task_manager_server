package ru.visdom.taskmanager.model

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,

        @Column(name = "name")
        val name: String
)