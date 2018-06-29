package com.yang.controller;

import com.yang.dto.CartDTO;
import com.yang.VO.ProdcutVo;
import com.yang.VO.ProductInfoVo;
import com.yang.VO.ResultVo;
import com.yang.dataobject.ProductCategory;
import com.yang.dataobject.ProductInfo;
import com.yang.service.CategoryService;
import com.yang.service.ProductService;
import com.yang.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    /**
     *
     * 功能描述:
     * 1.查询所有在架商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     * @param:
     * @return:
     * @auther: yang
     * @date: 2018\6\27 0027 10:32
     */
    @GetMapping("/list")
    public ResultVo<ProdcutVo> list(){
        //1.查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().
                     map(ProductInfo ::getCategoryType).collect(Collectors.toList());
        //3.从数据库查询类目
        List<ProductCategory>  productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
            //4.构造数据
            List<ProdcutVo> prodcutVoList = new ArrayList<>();
            for (ProductCategory productCategory :productCategoryList){
                ProdcutVo prodcutVo = new ProdcutVo();
            prodcutVo.setCategoryName(productCategory.getCategoryName());
            prodcutVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVOList.add(productInfoVo);
                }
            }
            prodcutVo.setProdcutInfoVoList(productInfoVOList);
            prodcutVoList.add(prodcutVo);
        }
        return ResultVoUtil.success(prodcutVoList);
    }

    /**
     * 获取商品列表（给订单服务用）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody  List<String> productIdList){
       return  productService.findList(productIdList);
    }

    /**
     * 扣库存（给订单服务用）
     * @param cartDTOList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }




}
