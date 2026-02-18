# Flexbox Basics

## 1. Introduction
Flexbox (Flexible Box Layout) is a one-dimensional layout method for laying out items in rows or columns. It makes it easy to design flexible responsive layout structures without using float or positioning.

## 2. Flex Container
To start using Flexbox, you need a **container**.
```css
.container {
  display: flex;
}
```

## 3. Flex Direction
Start laying out items in a Row (default) or Column.
```css
.container {
  flex-direction: row; /* Default: Left to Right */
  /* flex-direction: column; Top to Bottom */
}
```

## 4. Main Axis Alignment (`justify-content`)
Controls alignment along the **main axis** (usually horizontal).
- `flex-start`: Items pack toward the start line (default).
- `flex-end`: Items pack toward the end line.
- `center`: Items are centered along the line.
- `space-between`: Items are evenly distributed; first item is on the start line, last item on the end line.
- `space-around`: Items are evenly distributed with equal space around them.

## 5. Cross Axis Alignment (`align-items`)
Controls alignment along the **cross axis** (perpendicular to main axis).
- `stretch`: Stretch to fill the container (default).
- `flex-start`: Items are placed at the start of the cross axis.
- `flex-end`: Items are placed at the end of the cross axis.
- `center`: Items are centered in the cross-axis.

## 6. Example Layout
```css
.navbar {
  display: flex;
  justify-content: space-between; /* Logo left, Links right */
  align-items: center; /* Vertically center everything */
  padding: 10px;
}
```
This is the modern way to build Navigation Bars!
