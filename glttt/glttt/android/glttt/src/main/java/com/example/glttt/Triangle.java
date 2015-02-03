package com.example.glttt;

public class Triangle
{
	private float[] vertexData;
	
	private Triangle()
	{	
	}
	
	private Triangle( float[] vertexData, String id )
	{
		this.vertexData = vertexData;
		this.id = id;
	}
	
	public float[] getVertexData()
	{
		return vertexData;
	}
	
	public float getX( int vertexNum )
	{
		return vertexData[(vertexNum*7)];
	}
	
	public float getY( int vertexNum )
	{
		return vertexData[(vertexNum*7) + 1];
	}
	
	public float getZ( int vertexNum )
	{
		return vertexData[(vertexNum*7) + 2];
	}
	
	public static Triangle create( float[] vertices, float[] colour, float vertexDivideFactor, String id )
	{
		float[] vertexData = new float[21];
		for (int i=0; i<3; ++i)
		{
			vertexData[i*7] = (vertices[i*3] / vertexDivideFactor) - 1.0f;
			vertexData[(i*7) + 1] = (vertices[(i*3) + 1] / vertexDivideFactor) - 1.0f;
			vertexData[(i*7) + 2] = vertices[(i*3) + 2];
			
			for (int j=0; j<4; ++j)
			{
				vertexData[(i*7) + 3 + j] = colour[j];
			}
		}
		
		return new Triangle( vertexData, id );
	}
	
	public String toString()
	{
		return id;
	}
	
	private String id;
}
