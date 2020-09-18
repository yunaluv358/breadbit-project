package com.bread.web.shipping;

import com.bread.web.user.User;
import com.bread.web.utils.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

interface ShippingService extends GenericService<Shipping> {
    void allUpdate(List<Shipping> shipping);
    List<Shipping> findByShippingName(String shippingName);
}

@Service
@AllArgsConstructor
public class ShippingServiceImpl implements ShippingService{
    final private ShippingRepository shippingRepository;
    @Override
    public void save(Shipping shipping) {
        shippingRepository.save(shipping);
    }

    @Override
    public Optional<Shipping> findById(Long id) {
        return shippingRepository.findById(id);
    }

    @Override
    public Iterable<Shipping> findAll() {
        return shippingRepository.findAll();
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public void allUpdate(List<Shipping> shipping) {
        shippingRepository.saveAll(shipping);
    }

    @Override
    public List<Shipping> findByShippingName(String shippingName) {
        return shippingRepository.findByShippingName(shippingName);
    }
}
