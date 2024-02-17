package com.shopping.database.api.Database.API.Repository;

import com.shopping.database.api.Database.API.Models.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository

public interface PortalUserRepo extends JpaRepository<PortalUser, UUID> {
}
