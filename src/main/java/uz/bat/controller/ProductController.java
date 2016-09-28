package uz.bat.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.bat.model.entity.Product;

import uz.bat.service.ProductService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ProductController
{
    @Autowired
    ProductService productService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/product-view", method = RequestMethod.GET)
    public String view(Model model, HttpServletRequest request)
    {

        model.addAttribute("productList", productService.all());
        return "product/product-view";
    }

    @RequestMapping(value = "/product-edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request)
    {

        Product product = new Product();

        Long id = null;
        if (request.getParameter("id") != null)
            id = Long.valueOf(request.getParameter("id"));
        if (id != null && id > (long) 0)
        {
            product = productService.findOne(id);
        }
        model.addAttribute("product", product);
        model.addAttribute("productunitList", productService.allPproductunit());
        model.addAttribute("supplierList", productService.allSupplier());
        model.addAttribute("categoryList", productService.allCategory());
        model.addAttribute("brandBeanList", productService.allBrand());
        return "product/product-edit";
    }

    @RequestMapping(value = "/product-save", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request)
    {
        String productName = request.getParameter("productName");
        String productCode = request.getParameter("productCode");
        Double minPrice = Double.valueOf(request.getParameter("minPrice"));
        Double maxPrice = Double.valueOf(request.getParameter("maxPrice"));
        String location = request.getParameter("location");
        Product product = null;

        if (request.getParameter("idObject") != null && !request.getParameter("idObject").equals(""))
        {
            Long id = Long.valueOf(request.getParameter("idObject"));
            if (id != null & id > (long) 0)
                product = productService.findOne(id);
        } else
            product = new Product();

        Long productunitId = null;
        if (request.getParameter("productunitId") != null && !request.getParameter("productunitId").equals(""))
        {
            productunitId = Long.valueOf(request.getParameter("productunitId"));

        }
        if (productunitId != null && productunitId > (long) 0)
            product.setProductunit(productService.findProductunitById(productunitId));

        Long supplierId = null;
        if (request.getParameter("supplierId") != null && !request.getParameter("supplierId").equals(""))
        {
            supplierId = Long.valueOf(request.getParameter("supplierId"));

        }
        if (supplierId != null && supplierId > (long) 0)
            product.setSupplier(productService.findSupplierById(supplierId));

        Long categoryId = null;
        if (request.getParameter("categoryId") != null && !request.getParameter("categoryId").equals(""))
        {
            categoryId = Long.valueOf(request.getParameter("categoryId"));

        }
        if (categoryId != null && categoryId > (long) 0)
            product.setCategory(productService.findCategoryById(categoryId));

        Long brandId = null;
        if (request.getParameter("brandBeanId") != null && !request.getParameter("brandBeanId").equals(""))
        {
            brandId = Long.valueOf(request.getParameter("brandBeanId"));

        }
        if (brandId != null && brandId > (long) 0)
            product.setBrandBean(productService.findBrandById(brandId));


        if (maxPrice != null)
            product.setMaxPrice(maxPrice);
        if (minPrice != null)
            product.setMinPrice(minPrice);
        product.setProductName(productName);
        product.setProductCode(productCode);
        productService.create(product);
        logger.info(product.toString());
        return "redirect:/product-view";
    }

    @RequestMapping(value = "/product-delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request)
    {

        Long id = Long.valueOf(request.getParameter("id"));
        if (id != null)
            productService.remove(id);


        return "redirect:/product-view";
    }
}
