package com.example.dreamshop.repository;

import com.example.dreamshop.model.Cart;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CartRepository extends JpaRepository<Cart,Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Cart> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Cart> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Cart> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cart getOne(Long aLong) {
        return null;
    }

    @Override
    public Cart getById(Long aLong) {
        return null;
    }

    @Override
    public Cart getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Cart> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cart> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Cart> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cart> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cart> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Cart, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Cart> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cart> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Cart> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Cart> findAll() {
        return List.of();
    }

    @Override
    public List<Cart> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Cart entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cart> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Cart> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return null;
    }
}
