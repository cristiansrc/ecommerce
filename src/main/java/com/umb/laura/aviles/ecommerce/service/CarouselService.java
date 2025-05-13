package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.Carousel;
import com.umb.laura.aviles.ecommerce.repository.CarouselRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarouselService {

    private CarouselRepository carouselRepository;

    public Integer addCarousel(Carousel carousel) {
        return carouselRepository.addCarousel(carousel);
    }

    public Carousel getCarouselById(Integer id) {
        return carouselRepository.getCarouselById(id);
    }

    public List<Carousel> getAllCarousels() {
        return carouselRepository.getAllCarousels();
    }

    public void updateCarousel(Carousel carousel) {
        carouselRepository.updateCarousel(carousel);
    }

    public void deleteCarousel(Integer id) {
        carouselRepository.deleteCarousel(id);
    }
}
