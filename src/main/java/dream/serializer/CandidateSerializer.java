package dream.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import dream.model.CandidateJson;

import java.io.IOException;

public class CandidateSerializer extends StdSerializer<CandidateJson> {

    public CandidateSerializer() {
        this(null);
    }

    public CandidateSerializer(Class<CandidateJson> t) {
        super(t);
    }

    @Override
    public void serialize(
            CandidateJson candidate, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("firstName", candidate.getFirstName());
        jsonGenerator.writeStringField("lastName", candidate.getLastName());
        jsonGenerator.writeStringField("password", candidate.getPassword());
        jsonGenerator.writeEndObject();
    }
}
