package name.pawlitzki.boot.todoapp.routes;

import java.util.Arrays;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurationSupport;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class FluxRoutes extends WebFluxConfigurationSupport {

	@Bean
	public RouterFunction<ServerResponse> api() {
		return RouterFunctions.nest(RequestPredicates.path("/api/flux/"), apiRoutes());
	}

	@Bean
	public RouterFunction<ServerResponse> apiRoutes() {
		return RouterFunctions.nest(RequestPredicates.path("/todos"), todoApiRoutes());
	}

	@Bean
	public RouterFunction<ServerResponse> todoApiRoutes() {
		return RouterFunctions.route(RequestPredicates.GET("/"), this::echo);
	}

	public Mono<ServerResponse> echo(ServerRequest request) {
		Publisher<String> publisher = Flux.fromIterable(Arrays.asList("eins", "zwei", "drei"));
		return ServerResponse.ok().body(publisher, String.class);
	}

}
