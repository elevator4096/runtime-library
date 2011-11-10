/*
 * Copyright (c) 2011 NTB Interstate University of Applied Sciences of Technology Buchs.
 * All rights reserved.
 *
 * http://www.ntb.ch/inf
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the project's author nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package java.lang;

/**
 * The {@code Float} class wraps a value of the primitive type
 * {@code float} in an object. An object of type {@code Float}
 * contains a single field whose type is {@code float}.
 * 
 * changes:
 * 20.9.2011	NTB/Urs Graf	ported to deep
 *
 */

public class Float {

    /**
     * A constant holding the positive infinity of type
     * <code>float</code>. It is equal to the value returned by
     * <code>Float.intBitsToFloat(0x7f800000)</code>.
     */
    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;

    /**
     * A constant holding the negative infinity of type
     * <code>float</code>. It is equal to the value returned by
     * <code>Float.intBitsToFloat(0xff800000)</code>.
     */
    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;

    /** 
     * A constant holding a Not-a-Number (NaN) value of type
     * <code>float</code>.  It is equivalent to the value returned by
     * <code>Float.intBitsToFloat(0x7fc00000)</code>.
     */
    public static final float NaN = 0.0f / 0.0f;

    /**
     * A constant holding the largest positive finite value of type
     * <code>float</code>, (2-2<sup>-23</sup>)&middot;2<sup>127</sup>.
     * It is equal to the hexadecimal floating-point literal
     * <code>0x1.fffffeP+127f</code> and also equal to
     * <code>Float.intBitsToFloat(0x7f7fffff)</code>.
     */
    public static final float MAX_VALUE = 0x1.fffffeP+127f; // 3.4028235e+38f

    /**
     * A constant holding the smallest positive nonzero value of type
     * <code>float</code>, 2<sup>-149</sup>. It is equal to the
     * hexadecimal floating-point literal <code>0x0.000002P-126f</code>
     * and also equal to <code>Float.intBitsToFloat(0x1)</code>.
     */
    public static final float MIN_VALUE = 0x0.000002P-126f; // 1.4e-45f

	/**
	 * The number of bits used to represent a <tt>float</tt> value.
	 */
	public static final int SIZE = 32;

    /**
     * Returns a <tt>Float</tt> instance representing the specified
     * <tt>float</tt> value.
     * If a new <tt>Float</tt> instance is not required, this method
     * should generally be used in preference to the constructor
     * {@link #Float(float)}, as this method is likely to yield
     * significantly better space and time performance by caching
     * frequently requested values.
     *
     * @param  f a float value.
     * @return a <tt>Float</tt> instance representing <tt>f</tt>.
     */
    public static Float valueOf(float f) {
        return new Float(f);
    }

	/**
	 * The value of the {@code Float}.
	 *
	 * @serial
	 */
	private final float value;

    /**
     * Constructs a newly allocated <code>Float</code> object that
     * represents the primitive <code>float</code> argument.
     *
     * @param   value   the value to be represented by the <code>Float</code>.
     */
    public Float(float value) {
    	this.value = value;
    }

	/**
	 * Returns the {@code float} value of this
	 * {@code Float} object.
	 *
	 * @return the {@code float} value represented by this object
	 */
	public float floatValue() {
		return (float)value;
	}

}
