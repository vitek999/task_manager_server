package ru.visdom.taskmanager.model

import javax.persistence.*

@Entity
@Table(name = "tag")
data class Tag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,

        @Column(name = "name")
        val name: String
)