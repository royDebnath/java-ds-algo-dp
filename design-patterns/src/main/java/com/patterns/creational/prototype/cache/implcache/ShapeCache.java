package com.patterns.creational.prototype.cache.implcache;

import java.util.HashMap;
import java.util.Map;

import com.patterns.creational.prototype.cache.abstracts.Shape;
import com.patterns.creational.prototype.cache.concrete.Circle;
import com.patterns.creational.prototype.cache.concrete.Rectangle;

public class ShapeCache {
	
   private static Map<String, Shape> shapeMap  = new HashMap<String, Shape>();

   public static Shape getShape(String shapeId) {
      Shape cachedShape = shapeMap.get(shapeId);
      return (Shape) cachedShape.clone();
   }

   // for each shape run database query and create shape
   // shapeMap.put(shapeKey, shape);
   // for example, we are adding three shapes
   
   public static void loadCache() {
      Circle circle = new Circle(); //get circle from database
      circle.setId("1");
      shapeMap.put(circle.getId(),circle);

      Rectangle rectangle = new Rectangle();
      rectangle.setId("3");
      shapeMap.put(rectangle.getId(), rectangle);
   }
}