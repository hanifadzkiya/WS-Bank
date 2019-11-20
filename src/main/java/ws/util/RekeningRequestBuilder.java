package ws.util;

import ws.model.Rekening;

public class RekeningRequestBuilder {
    public String noRekening;

    public RekeningRequestBuilder(String noRekening) {
        this.noRekening = noRekening;
    }

    public RekeningRequestBuilder setNoRekening(String noRekening) {
        this.noRekening = noRekening;
        return this;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public RekeningRequest build(){
        return new RekeningRequest(this);
    }
}
