package com.platzerworld.biergarten;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestbookRepository extends JpaRepository<GuestbookEntry, Long> {

	public List<GuestbookEntry> findAllByOrderByIdDesc();
 
}
