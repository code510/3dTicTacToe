package com.example.glttt.shader;

import android.opengl.GLES20;

import com.example.glttt.shapes.Triangle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class SimpleShader implements IShader {
    private ShaderProgram mProgram;
    private int mPositionHandle;
    private int mMVPMatrixHandle;
    private int mColourHandle;

    SimpleShader( ShaderProgram program ) {
        mProgram = program;
    }

    @Override
    public int getProgramHandle() {
        return mProgram.getProgramHandle();
    }

    @Override
    public boolean requiresNormalData() {
        return false;
    }

    @Override
    public void initialize() {
        mProgram.initialize();

        int program = mProgram.getProgramHandle();

        mPositionHandle = GLES20.glGetAttribLocation(program, "a_position");
        if (mPositionHandle == -1) {
            throw new ShaderException("could not get position handle");
        }
        mMVPMatrixHandle = GLES20.glGetUniformLocation(program, "u_VPMatrix");
        if (mMVPMatrixHandle == -1) {
            throw new ShaderException("could not get MVP matrix handle");
        }
        mColourHandle = GLES20.glGetAttribLocation(program, "a_color");
        if (mColourHandle == -1) {
            throw new ShaderException("could not get color handle");
        }
    }

    @Override
    public void draw( float[] mvMatrix, float[] mvpMatrix, Iterable<Triangle> tris ) {
        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);

        for (Triangle t : tris)
        {
            drawTriangle(t);
        }
    }

    private void drawTriangle(Triangle tri) {
        float[] vertexData = tri.getVertexData();
        ByteBuffer vertexBB = ByteBuffer.allocateDirect(vertexData.length * 4);
        vertexBB.order(ByteOrder.nativeOrder());
        FloatBuffer vertexFB = vertexBB.asFloatBuffer();
        vertexFB.put(vertexData);

        vertexFB.position(0);
        GLES20.glVertexAttribPointer(mPositionHandle, 3, GLES20.GL_FLOAT, false, 28, vertexFB);
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        vertexFB.position(3);
        GLES20.glVertexAttribPointer(mColourHandle, 4, GLES20.GL_FLOAT, false, 28, vertexFB);
        GLES20.glEnableVertexAttribArray(mColourHandle);

        //Draw the shape
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
    }
}