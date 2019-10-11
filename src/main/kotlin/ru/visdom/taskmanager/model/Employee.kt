package ru.visdom.taskmanager.model

import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "user_id")
        val userId: Long,

        @Column(name = "subdivision_id")
        val subdivisionId: Long,

        @Column(name = "role_id")
        val roleId: Long
)

