package com.eveningoutpost.dexdrip.G5Model;

import com.eveningoutpost.dexdrip.Models.JoH;
import com.eveningoutpost.dexdrip.Models.UserError;
import com.eveningoutpost.dexdrip.Services.G5CollectionService;

import java.nio.ByteBuffer;

/**
 * Created by jamorham on 25/11/2016.
 */

public class BatteryInfoTxMessage extends TransmitterMessage {

    private final static String TAG = G5CollectionService.TAG; // meh
    byte opcode = 0x22;
    private byte[] crc = CRC.calculate(opcode);

    public BatteryInfoTxMessage() {
        data = ByteBuffer.allocate(3);
        data.put(opcode);
        data.put(crc);
        byteSequence = data.array();
        UserError.Log.e(TAG, "BatteryInfoTx dbg: " + JoH.bytesToHex(byteSequence));
    }
}

