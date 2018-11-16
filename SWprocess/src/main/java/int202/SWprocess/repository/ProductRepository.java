/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.repository;

import int202.SWProcess.model.Product;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.hibernate.hql.internal.antlr.HqlSqlTokenTypes.FROM;
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kittisak
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
<<<<<<< Updated upstream
=======
    public List<Product> findByProductId(int productId);
    public List<Product> findByProductNameLike(String productName);
    
    @Query("SELECT productImage FROM Product where image = :image")
    public String findImageById(@Param("image")String image);
     @Query(value = "select productName from Product where productId = ?1", nativeQuery = true)
    public Product findProductNameByID(String productName);
//    public Optional<Product> findAllProduct(long productId,String productName,String productDetail,String productImage,double productPrice);
    
    
>>>>>>> Stashed changes
}
