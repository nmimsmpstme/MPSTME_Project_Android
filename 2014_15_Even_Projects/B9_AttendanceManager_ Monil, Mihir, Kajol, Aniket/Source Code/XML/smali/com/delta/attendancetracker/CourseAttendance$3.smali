.class Lcom/delta/attendancetracker/CourseAttendance$3;
.super Ljava/lang/Object;
.source "CourseAttendance.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/delta/attendancetracker/CourseAttendance;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/delta/attendancetracker/CourseAttendance;


# direct methods
.method constructor <init>(Lcom/delta/attendancetracker/CourseAttendance;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/delta/attendancetracker/CourseAttendance$3;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .parameter "arg0"

    .prologue
    .line 172
    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$3;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v2, v2, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 173
    .local v0, hMinus:I
    add-int/lit8 v0, v0, -0x1

    .line 175
    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$3;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v2, v2, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 177
    .local v1, t:I
    if-ltz v0, :cond_0

    if-lt v0, v1, :cond_0

    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$3;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v2, v2, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 179
    :cond_0
    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$3;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    invoke-virtual {v2}, Lcom/delta/attendancetracker/CourseAttendance;->update()V

    .line 181
    return-void
.end method
