/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWProcess.model;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Kittisak
 */
@Entity
@Table(name = "seller")
public class Seller extends SerializableSerializer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sellerId;
    
    @NotBlank
    private String shopName;
    
    @NotBlank
    private String shopDetails;
    
    @NotBlank
    private long productId;
    
    @NotBlank
    private long userId;

}
