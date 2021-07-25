package de.bluecolored.bluemap.core.map.hires;

import de.bluecolored.bluemap.core.util.math.MatrixM3f;
import de.bluecolored.bluemap.core.util.math.MatrixM4f;

public class BlockModelView {

    private HiresTileModel hiresTile;
    private int start, size;

    public BlockModelView(HiresTileModel hiresTile) {
        initialize(hiresTile);
    }

    public BlockModelView initialize(HiresTileModel hiresTile, int start) {
        this.hiresTile = hiresTile;
        this.start = start;
        this.size = hiresTile.size() - start;

        return this;
    }

    public BlockModelView initialize(HiresTileModel hiresTile) {
        this.hiresTile = hiresTile;
        this.start = hiresTile.size();
        this.size = 0;

        return this;
    }

    public BlockModelView initialize(int start) {
        this.start = start;
        this.size = hiresTile.size() - start;

        return this;
    }

    public BlockModelView initialize() {
        this.start = hiresTile.size();
        this.size = 0;

        return this;
    }

    public BlockModelView reset() {
        hiresTile.reset(this.start);
        this.size = 0;

        return this;
    }

    public int add(int count) {
        int s = hiresTile.add(count);
        if (s != start + size) throw new IllegalStateException("Size of HiresTileModel had external changes since view-initialisation!");
        this.size += count;
        return s;
    }

    public BlockModelView rotate(float angle, float axisX, float axisY, float axisZ) {
        hiresTile.rotate(start, size, angle, axisX, axisY, axisZ);
        return this;
    }

    public BlockModelView rotate(float pitch, float yaw, float roll) {
        hiresTile.rotate(start, size, pitch, yaw, roll);
        return this;
    }

    public BlockModelView scale(double sx, double sy, double sz) {
        hiresTile.scale(start, size, sx, sy, sz);
        return this;
    }

    public BlockModelView translate(double dx, double dy, double dz) {
        hiresTile.translate(start, size, dx, dy, dz);
        return this;
    }

    public BlockModelView transform(MatrixM3f t) {
        hiresTile.transform(start, size, t);
        return this;
    }

    public BlockModelView transform(
            float m00, float m01, float m02,
            float m10, float m11, float m12,
            float m20, float m21, float m22
    ) {
        hiresTile.transform(start, size,
                m00, m01, m02,
                m10, m11, m12,
                m20, m21, m22
        );
        return this;
    }

    public BlockModelView transform(MatrixM4f t) {
        hiresTile.transform(start, size, t);
        return this;
    }

    public BlockModelView transform(
            float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ) {
        hiresTile.transform(start, size,
                m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33
        );
        return this;
    }

    public HiresTileModel getHiresTile() {
        return hiresTile;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }

}