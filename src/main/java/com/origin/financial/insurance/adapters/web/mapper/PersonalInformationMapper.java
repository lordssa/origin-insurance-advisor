package com.origin.financial.insurance.adapters.web.mapper;

import com.origin.financial.insurance.adapters.web.dto.input.HouseRequest;
import com.origin.financial.insurance.adapters.web.dto.input.PersonalInformationRequest;
import com.origin.financial.insurance.adapters.web.dto.input.VehicleRequest;
import com.origin.financial.insurance.application.entities.*;

import java.time.LocalDate;

import static java.util.Optional.ofNullable;

public class PersonalInformationMapper {

    public static CustomerProfile toEntity(PersonalInformationRequest personalInformationRequest) {
        final var baseScore = personalInformationRequest.getRiskQuestions()
                .stream()
                .reduce(0, Integer::sum);

        final var maritalStatus = MaritalStatus
                .getByDescription(personalInformationRequest.getMaritalStatus());

        return CustomerProfile
                .builder()
                .age(personalInformationRequest.getAge())
                .baseScore(baseScore)
                .house(getHouse(personalInformationRequest))
                .income(personalInformationRequest.getIncome())
                .maritalStatus(maritalStatus)
                .numberDependents(personalInformationRequest.getDependents())
                .vehicle(getVehicle(personalInformationRequest))
                .build();
    }

    private static Vehicle getVehicle(PersonalInformationRequest personalInformationRequest) {
        return ofNullable(personalInformationRequest.getVehicle())
                .map(VehicleRequest::getYear)
                .map(vehicleYear ->
                        Vehicle
                                .builder()
                                .age(LocalDate.now().getYear() - vehicleYear)
                                .build())
                .orElse(null);
    }

    private static House getHouse(PersonalInformationRequest personalInformationRequest) {
        return ofNullable(personalInformationRequest.getHouse())
                .map(HouseRequest::getOwnershipStatus)
                .map(ownershipStatus ->
                        House
                                .builder()
                                .ownershipStatus(
                                        OwnershipStatus.getByDescription(ownershipStatus))
                                .build())
                .orElse(null);
    }
}
