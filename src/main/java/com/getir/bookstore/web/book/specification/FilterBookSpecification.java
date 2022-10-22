package com.getir.bookstore.web.book.specification;

import com.getir.bookstore.common.specification.BaseSpecification;
import com.getir.bookstore.common.utils.StringUtils;
import com.getir.bookstore.core.book.model.domain.Book;
import com.getir.bookstore.core.book.model.dto.FilterBookDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FilterBookSpecification implements BaseSpecification<Book, FilterBookDTO> {

    public static final String AUTHOR ="author";
    public static final String TITLE ="title";
    public static final String ISBN ="isbn";

    @Override
    public Specification<Book> filter(FilterBookDTO filterBookDTO) {

        return (root, criteria, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isBlank(filterBookDTO.getAuthor())) {
                predicates.add(cb.like(root.get(AUTHOR), "%" + filterBookDTO.getAuthor() + "%"));
            }

            if (!StringUtils.isBlank(filterBookDTO.getIsbn())) {
                predicates.add(cb.equal(root.get(ISBN), filterBookDTO.getIsbn()));
            }

            if (!StringUtils.isBlank(filterBookDTO.getTitle())) {
                predicates.add(cb.like(root.get(TITLE), "%" + filterBookDTO.getTitle() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

    }
}
