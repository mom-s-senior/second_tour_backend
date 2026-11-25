package ru.nto.team

import org.springframework.stereotype.Service

@Service
class StaffService(private val staffRepository: StaffRepository) {
    fun profile(code: String): ProfileDto {
        val staff = staffRepository.findByCode(code) ?: throw StaffNotFoundException(code)

        return ProfileDto(staff.id, staff.fullName)
    }
}
