/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.driver.ser.binary.types;

import org.apache.tinkerpop.gremlin.driver.ser.SerializationException;
import org.apache.tinkerpop.gremlin.driver.ser.binary.DataType;
import org.apache.tinkerpop.gremlin.driver.ser.binary.GraphBinaryReader;
import org.apache.tinkerpop.gremlin.driver.ser.binary.GraphBinaryWriter;
import org.apache.tinkerpop.gremlin.structure.io.Buffer;

import java.time.Period;

/**
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public class PeriodSerializer extends SimpleTypeSerializer<Period> {
    public PeriodSerializer() {
        super(DataType.PERIOD);
    }

    @Override
    protected Period readValue(final Buffer buffer, final GraphBinaryReader context) throws SerializationException {
        return Period.of(buffer.readInt(), buffer.readInt(), buffer.readInt());
    }

    @Override
    protected void writeValue(final Period value, final Buffer buffer, final GraphBinaryWriter context) throws SerializationException {
        buffer.writeInt(value.getYears()).writeInt(value.getMonths()).writeInt(value.getDays());
    }
}
