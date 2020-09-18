package com.bread.web.shipping;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController @AllArgsConstructor
@RequestMapping("/shipping")
public class ShippingController {
    private final ShippingService shippingService;
    private final ShippingRepository shippingRepository;

    @PostMapping("/payment")
    public String register(@RequestBody Shipping shipping) {
        shippingRepository.save(shipping);
        return "배송 데이터 저장완료";
    }
    @GetMapping("/{shippingName}")
    public List<Shipping> findUser(@PathVariable String shippingName) {
        List<Shipping> shipping = shippingService.findByShippingName(shippingName);
        System.out.println("주문자 정보"+shipping);
        return shipping;
    }

    // 리스트로 전부찾기
    @GetMapping("/findAll")
    public List<Shipping> findAll() { return shippingRepository.findAll();}

    // 정보 수정
    @PostMapping("/allUpdate")
    public void allUpdate(@RequestBody List<Shipping> shipping){
        shippingService.allUpdate(shipping);
    }
}
