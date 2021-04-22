package net.yl.rpc.codec;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author yulei0
 * @date 2021/4/22
 */
public class JdkCodec extends AbstractCodec {

    @Override
    public <S> byte[] encode(S source) throws IOException {
        ByteOutputStream bos = new ByteOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(source);
        return bos.getBytes();
    }

    @Override
    public <S> S decode(Class<S> clazz, byte[] encoded) throws IOException {
        ByteInputStream bis = new ByteInputStream(encoded, encoded.length);
        ObjectInputStream ois = new ObjectInputStream(bis);
        try {
            return (S)ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("decode error", e);
        }
    }
}
