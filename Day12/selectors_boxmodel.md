# Selectors & The Box Model

## 1. CSS Selectors

### A. Element Selector
Selects all elements of a given type.
```css
p {
  color: red; /* All paragraphs will be red */
}
```

### B. ID Selector (`#`)
Selects a **unique** element with a specific `id` attribute. High Priority.
```css
#header {
  background-color: gray;
}
```
HTML: `<div id="header">...</div>`

### C. Class Selector (`.`)
Selects elements with a specific `class` attribute. Can be reused. **Most Common**.
```css
.center {
  text-align: center;
}
```
HTML: `<h1 class="center">...</h1>` and `<p class="center">...</p>`

### D. Universal Selector (`*`)
Selects all elements. Often used to reset margins.
```css
* {
  margin: 0;
  padding: 0;
}
```

## 2. Priority (Specificity)
If rules conflict, the browser decides which one to apply:
1.  **Inverse (Inline Style)** (Highest)
2.  **ID Selector**
3.  **Class Selector**
4.  **Element Selector** (Lowest)

## 3. The Box Model
Every HTML element is essentially a box. It has 4 layers (from inside out):

1.  **Content**: The actual text or image.
2.  **Padding**: Space *inside* the border, around the content. Clears an area around the content. (Transparent)
3.  **Border**: A border that goes around the padding and content.
4.  **Margin**: Space *outside* the border. Separates this element from neighbors. (Transparent)

### Visualization
```
---------------------------------------
|               Margin                |
|  ---------------------------------  |
|  |            Border             |  |
|  |  ---------------------------  |  |
|  |  |         Padding         |  |  |
|  |  |  ---------------------  |  |  |
|  |  |  |      Content      |  |  |  |
|  |  |  ---------------------  |  |  |
|  |  ---------------------------  |  |
|  ---------------------------------  |
---------------------------------------
```
