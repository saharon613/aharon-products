package aharon.products;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ProductsService { // this will request the JSON, it describes how we get the data from the web server (the website)

    @GET("/products")
    Single<ProductsResponse> getProducts();
}

