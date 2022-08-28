package com.example.first;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import static java.lang.System.out;


@Slf4j
//@SpringBootTest
class FirstApplicationTests {
	//Logger log = LoggerFactory.getLogger(FirstApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	void reactorFun() {
		Flux<String> fruitFlux = Flux.just("Apple","Orange","Banana","Cherry","Melon");
		fruitFlux.subscribe(elem -> {
			out.println(elem);
		}
		);

		fruitFlux.subscribe(elem -> out.println(elem));


		Mono<String> fruitMono = Mono.just("Apple");
		fruitMono.subscribe(out::println);

		StepVerifier.create(fruitFlux)
				.expectNext("Apple")
				.expectNext("Orange")
				.expectNext("Banana")
				.expectNext("Cherry")
				.expectNext("Melon")
				.verifyComplete();
		

		Flux<Long> numbersFlux = Flux.fromArray(new Long[] {1l,2l,3l,4l,5l,6l,7l});
		numbersFlux.subscribe(out::println);

		ArrayList<Integer> intArrayList = new ArrayList();
		intArrayList.add(222);
		intArrayList.add(333);
		Flux<Integer> fluxFromIntArrayList = Flux.fromIterable(intArrayList);
		fluxFromIntArrayList.subscribe(out::println);

		out.println("begin flux range");
		Flux<Integer> fluxRange = Flux.range(1,3);
		fluxRange.subscribe(out::println);
		out.println("end flux range");


		out.println("begin flux interval");
		Flux<Long> fluxInterval = Flux.interval(Duration.ofSeconds(1)).take(4);
		fluxInterval.subscribe(out::println);
		StepVerifier.create(fluxInterval)
			.expectNext(0L)
			.expectNext(1L)
			.expectNext(2L)
			.expectNext(3L)
			.verifyComplete();
		out.println("end flux interval");


	}

	@Test
	public void builderTest() {
		Client c = new Client.Builder()
				.firstName("Ivan")
				.midName("Ivanovich")
				.lastName("Ivanov")
				.age(25)
				.build();
		out.println(c);
	}

	@Test
	public void biFuncTest() {
		log.info("begin biFuncTest");
		BiFunction<List<String>,List<String>,List<String>> bf = (l1, l2) -> {
			List<String> res = new ArrayList<>();
			res.addAll(l1);
			res.addAll(l2);
			return res;
		};

		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		l1.add("1");
		l1.add("2");
		l2.add("3");
		l2.add("4");
		bf.apply(l1,l2).stream().forEach(out::println);

	}

	@Test public void loggerFun() {
		log.debug("loggerFun");
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
	}

}