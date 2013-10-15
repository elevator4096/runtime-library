/*
 * Copyright 2011 - 2013 NTB University of Applied Sciences in Technology
 * Buchs, Switzerland, http://www.ntb.ch/inf
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package java.lang;


/**
 * The {@code Character} class wraps a value of primitive type 
 * {@code char} in an object. An object of type {@code Character}
 * contains a single field whose type is {@code char}.
 * 
 * changes:
 * 20.9.2011	NTB/Urs Graf	ported to deep
 *
 */
public class Character {

    /**
     * The constant value of this field is the smallest value of type
     * <code>char</code>, <code>'&#92;u0000'</code>.
     */
    public static final char   MIN_VALUE = '\u0000';

    /**
     * The constant value of this field is the largest value of type
     * <code>char</code>, <code>'&#92;uFFFF'</code>.
     */
    public static final char   MAX_VALUE = '\uffff';
	
    /**
     * Returns a <code>String</code> object representing this
     * <code>Character</code>'s value.  The result is a string of
     * length 1 whose sole component is the primitive
     * <code>char</code> value represented by this
     * <code>Character</code> object.
     *
     * @return  a string representation of this object.
     */
    public String toString() {
        char buf[] = {value};
        return new String(buf);
    }

	/**
	 * Returns a {@code Character} instance representing the specified
	 * {@code char} value.
	 *
	 * @param  c a char value.
	 * @return a {@code Character} instance representing {@code c}.
	 */
	public static Character valueOf(char c) {
		return new Character(c);
	}


	/**
	 * The value of the {@code Character}.
	 *
	 * @serial
	 */
	private final char value;

	/**
     * Constructs a newly allocated <code>Character</code> object that
     * represents the specified <code>char</code> value.
     *
     * @param  value   the value to be represented by the 
     *                  <code>Character</code> object.
	 */
    public Character(char value) {
        this.value = value;
    }

    /**
     * Returns the value of this <code>Character</code> object.
     * @return  the primitive <code>char</code> value represented by
     *          this object.
     */
    public char charValue() {
        return value;
    }


}
