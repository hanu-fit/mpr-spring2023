# Lecture Guides

## View Persistence Demo

### Problem
- Run app without input ids
- Rotate screen & observe data loss

### Simple solution
- Add some input ids [name, phone]
- Run app again > rotate > observe difference (with vs without ids)

### Complete solution
- for other elements (video playback position, ...)

- onSaveInstanceState() 
- onRestoreInstanceSTate()