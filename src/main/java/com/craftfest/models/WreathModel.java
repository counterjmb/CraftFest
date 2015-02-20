package com.craftfest.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class WreathModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer shape2;
    ModelRenderer shape3;
    ModelRenderer shape4;
  
  public WreathModel()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      shape2 = new ModelRenderer(this, 0, 0);
      shape2.addBox(0F, 0F, 0F, 6, 2, 2);
      shape2.setRotationPoint(0F, 0F, 0F);
      shape2.setTextureSize(32, 32);
      shape2.mirror = true;
      setRotation(shape2, 1.561502F, 0.0743572F, 0F);
      shape2 = new ModelRenderer(this, 0, 0);
      shape2.addBox(0F, 0F, 0F, 6, 2, 2);
      shape2.setRotationPoint(0F, 6F, 0F);
      shape2.setTextureSize(32, 32);
      shape2.mirror = true;
      setRotation(shape2, 1.561502F, 0.0743572F, 0F);
      shape2 = new ModelRenderer(this, 0, 0);
      shape2.addBox(0F, 0F, -2F, 6, 2, 2);
      shape2.setRotationPoint(-2F, 0F, 0F);
      shape2.setTextureSize(32, 32);
      shape2.mirror = true;
      setRotation(shape2, -3.141593F, 0F, 1.59868F);
      shape2 = new ModelRenderer(this, 0, 0);
      shape2.addBox(0F, 0F, 0F, 6, 2, 2);
      shape2.setRotationPoint(6F, 0F, 2F);
      shape2.setTextureSize(32, 32);
      shape2.mirror = true;
      setRotation(shape2, -3.141593F, 0F, 1.59868F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    shape2.render(f5);
    shape2.render(f5);
    shape2.render(f5);
    shape2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
