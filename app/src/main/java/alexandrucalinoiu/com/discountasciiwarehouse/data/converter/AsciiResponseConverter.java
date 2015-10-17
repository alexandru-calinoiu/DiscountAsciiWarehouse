package alexandrucalinoiu.com.discountasciiwarehouse.data.converter;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import alexandrucalinoiu.com.discountasciiwarehouse.domain.model.Ascii;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class AsciiResponseConverter implements Converter {
  @Override
  public Object fromBody(TypedInput body, Type type) throws ConversionException {
    List<Ascii> result = new ArrayList<>();

    try {
      InputStream in = body.in();

      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      String line;
      while ((line = reader.readLine()) != null) {
        result.add(new Gson().fromJson(line, Ascii.class));
      }

      in.close();
    } catch (IOException e) {
      throw new ConversionException(e);
    }

    return result;
  }

  @Override
  public TypedOutput toBody(Object object) {
    return null;
  }
}
