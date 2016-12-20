package com.learning;

import static com.learning.supportUtils.CLIHandler.*;
import com.learning.supportUtils.ReaderFromFile;

import java.io.IOException;

public class cp {
    public static void main(String[] args) throws IOException{
        ReaderFromFile.copyWithConvert(parse(args));
    }
}
