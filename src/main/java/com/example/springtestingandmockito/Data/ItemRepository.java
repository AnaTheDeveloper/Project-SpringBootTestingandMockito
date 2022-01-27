package com.example.springtestingandmockito.Data;


import com.example.springtestingandmockito.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
