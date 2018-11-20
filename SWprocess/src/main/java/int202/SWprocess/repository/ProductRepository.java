/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.repository;

import int202.SWProcess.model.Products;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.hibernate.hql.internal.antlr.HqlSqlTokenTypes.FROM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kittisak
 */
@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{

    public List<Products> findByProductId(long productId);
    public List<Products> findByProductNameLike(String productName);
    public Products findById(long productId);
    
}
