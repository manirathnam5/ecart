package com.ecom.ecart.spec;

import com.ecom.ecart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {


    public static Specification<Product>  hasCategory(String category){

        return ((root, query, criteriaBuilder) ->
                category == null ? null : criteriaBuilder.equal(root.get("category"),category));

    }


   public static Specification<Product>  priceBetween(Double minPrice , Double maxPrice){

        return (root, query, criteriaBuilder) -> {
            if(minPrice == null && maxPrice == null)
                return  null;
            if(minPrice == null )
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"),maxPrice);
            if(maxPrice == null )
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"),minPrice);
            return criteriaBuilder.between(root.get("price"),minPrice,maxPrice);
        };

   }

    public static Specification<Product> hasNameOrDescription(String keyword) {

        return (root, query, criteriaBuilder) -> {

            if(keyword == null || keyword.isEmpty()) return null;
            return criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), "%"+ keyword.toLowerCase()+"%"),
                    criteriaBuilder.like(root.get("description"),"%"+ keyword.toLowerCase()+"%")
            );
        };

    }
}
