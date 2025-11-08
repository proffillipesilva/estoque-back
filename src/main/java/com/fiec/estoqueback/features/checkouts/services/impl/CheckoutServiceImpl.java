package com.fiec.estoqueback.features.checkouts.services.impl;

import com.fiec.estoqueback.features.checkouts.models.Checkout;
import com.fiec.estoqueback.features.checkouts.models.dto.CheckoutRequestDto;
import com.fiec.estoqueback.features.checkouts.repositories.CheckoutRepository;
import com.fiec.estoqueback.features.checkouts.services.CheckoutService;
import com.fiec.estoqueback.features.product.models.Product;
import com.fiec.estoqueback.features.product.repositories.ProductRepository;
import com.fiec.estoqueback.features.user.models.User;
import com.fiec.estoqueback.features.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UUID checkout(CheckoutRequestDto checkoutRequestDto) {
        User user = userRepository.findById(UUID.fromString(checkoutRequestDto.getUserId())).orElseThrow();
        Product product = productRepository.findById(UUID.fromString(checkoutRequestDto.getProductId())).orElseThrow();
        Checkout checkout = new Checkout();
        checkout.setUser(user);
        checkout.setProduct(product);
        checkout.setPreco(checkout.getPreco());
        checkout.setQuantidade(checkout.getQuantidade());
        checkoutRepository.save(checkout);

        Double quantidadeAtual = product.getQuantidade();
        double novaQuantidade = quantidadeAtual - checkoutRequestDto.getQuantidade();
        if(novaQuantidade < 0) throw new RuntimeException();

        product.setQuantidade(novaQuantidade);
        Product p = productRepository.save(product);
        return p.getId();


    }

    @Override
    public void deleteCheckout(String id, User user) {
        checkoutRepository.softDeleteById(UUID.fromString(id));
    }
}
